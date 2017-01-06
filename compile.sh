#!/bin/bash
set -e

dev=0
if [ "a$1" == "adev" ]; then
    dev=1
fi

function prefixOutput() {
    while read line; do
        echo "$1$line"
    done
}

# Update the PATH
source ~/.rvm/scripts/rvm
rvm use 2.3.0
PATH=$PATH:node_modules/.bin/:$(bundle show jekyll)/exe/

# Download external scripts
wget https://github.com/andrastoth/webcodecamjs/archive/master.zip
unzip master.zip
rm master.zip
mkdir -p audio
cp webcodecamjs-master/audio/beep.mp3 audio/
cp webcodecamjs-master/js/{qrcodelib,webcodecamjquery,DecoderWorker}.js js/
rm -rf webcodecamjs-master

wget https://github.com/Cerealkillerway/materialNote/archive/master.zip
unzip master.zip
rm master.zip
cp materialNote-master/{js/{materialNote,ckMaterializeOverrides},lib/codeMirror/{codemirror,xml}}.js js/
cp materialNote-master/css/{materialNote,codeMirror/{codemirror,monokai}}.css css/
mkdir -p font
cp -R materialNote-master/font/* font/
rm -rf materialNote-master

# Build Jekyll content
if [ $dev -eq 1 ]; then
    jekyll serve -H 0.0.0.0 | prefixOutput "[Jekyll]     " &
else
    jekyll build
fi

# Transpile typescipts
if [ $dev -eq 1 ]; then
    tsc -p _site --sourceMap -w | prefixOutput "[TypeScript] " &
else
    tsc -p _site --sourceMap || true
fi

# Run the development server in the background
if [ $dev -eq 1 ]; then
    echo "Press any key to shut down the development server."
    read -sN1
    kill $(jobs -p)
fi
