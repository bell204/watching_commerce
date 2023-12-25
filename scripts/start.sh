#!/bin/bash

source ~/deploy/profile.sh

PROFILE=$(get_profile)

echo "> deploy 폴더 이동"

cd ~/deploy

echo "> docker image 업데이트"

docker-compose pull

echo "> profile=$PROFILE로 컨테이너를 실행합니다"
docker-compose up -d $PROFILE