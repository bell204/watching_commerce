#!/usr/bin/env bash
source ~/deploy/profile.sh
PORT=$(get_port)

echo "> $PORT 에서 구동 중인 애플리케이션 pid 확인"
PID=$(lsof -ti tcp:${PORT})

cd ~/deploy


if [ -z ${PID} ]
then
  echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
else
  if [ ${PID}=8000 ]
  then
    echo "> port : $PID로 실행중인 real1을 컨테이너 종료합니다."
    docker-compose kill real1
  fi
  sleep 10
fi