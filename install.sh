#!/bin/bash
set -e

# Install javascript dependencies
npm install
node node_modules/.bin/typings install

# Install ruby dependencies
source ~/.rvm/scripts/rvm
rvm install 2.3.0
rvm use 2.3.0
rvm rubygems latest
ruby --version

# Install bundler
bundle install
