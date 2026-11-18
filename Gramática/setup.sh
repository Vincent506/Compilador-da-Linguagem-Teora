#!/usr/bin/env bash
# Prepara o ambiente (Ubuntu): ferramentas + ANTLR 4.13.2 (gerador E runtime na
# MESMA versão, pois os pacotes do apt têm versões diferentes entre si e não
# funcionam juntos). Tudo do ANTLR fica na pasta ./vendor.
set -euo pipefail
cd "$(dirname "$0")"

VERSION=4.13.2
JAR="vendor/antlr-$VERSION-complete.jar"
SRC="vendor/antlr4-$VERSION"
LIB="vendor/build/runtime/libantlr4-runtime.a"

if [ -z "${SKIP_APT:-}" ]; then
  SUDO=""; [ "$(id -u)" -ne 0 ] && SUDO="sudo"
  $SUDO apt-get update
  $SUDO apt-get install -y g++ make cmake default-jre-headless curl
fi

mkdir -p vendor

if [ ! -f "$JAR" ]; then
  echo ">> Baixando o gerador ANTLR $VERSION"
  curl -fL -o "$JAR" "https://www.antlr.org/download/antlr-$VERSION-complete.jar"
fi

if [ ! -d "$SRC" ]; then
  echo ">> Baixando o código do runtime C++ $VERSION"
  curl -fL "https://github.com/antlr/antlr4/archive/refs/tags/$VERSION.tar.gz" | tar xz -C vendor
fi

if [ ! -f "$LIB" ]; then
  echo ">> Compilando o runtime C++ (leva alguns minutos, só na primeira vez)"
  cmake -S "$SRC/runtime/Cpp" -B vendor/build -DCMAKE_BUILD_TYPE=Release \
        -DANTLR_BUILD_CPP_TESTS=OFF -DCMAKE_CXX_FLAGS="-w"
  cmake --build vendor/build --target antlr4_static -j"$(nproc)"
fi

echo ">> Pronto. Agora rode:  make"