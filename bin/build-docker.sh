#!/usr/bin/env sh

print_help() {
  echo "Script to build docker image using the provided Dockerfile
  Usage:
  ./build-docker.sh [OPTIONS]
  Options:
    --clean, -c                         Clean and install current state of source code
    --version VERSION=, -v VERSION=     Mandatory docker image version, ex. 0.1
    --help, -h                          Print this help blocks

  Example run command: ./bin/build-docker.sh -c -v 0.1"
}

# script execution flags
GRADLE_CLEAN=false

execute_script() {
  cd $(dirname "$0")/..

  if [ ${GRADLE_CLEAN} = true ]
  then
    echo "\nClearing previous build.."
    ./gradlew clean
  fi

  echo "\nBuilding distribution.."
  ./gradlew build

  if [ ${VERSION} ]
  then
    echo "\nBuilding the docker image expenses-registry:${VERSION}.."
    docker build -t expenses-registry:${VERSION} .
  else
    echo "\nERROR: Unable to build docker image! Version not set!"
  fi
}

while true ; do
  case "$1" in
    -h|--help) print_help ; shift ; break ;;
    -c|--clean) GRADLE_CLEAN=true ; shift ;;
    -v|--version) VERSION=${2}; shift ;;
    *) execute_script ; break ;;
  esac
done