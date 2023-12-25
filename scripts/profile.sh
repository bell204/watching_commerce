#!/usr/bin/env bash


function get_profile() {
  RESPONSE_CODE=$(curl -s -o /dev/null -w "%{http_code}" http://localhost/api/profile)
  if [ ${RESPONSE_CODE} -ge 400]
  then
    CURRENT_PROFILE=dev
  else
    CURRENT_PROFILE=$(curl -s http://localhost/api/profile)
  fi

  echo "${PROFILE}"
}

function get_port() {
    PROFILE=$(get_profile)
    if [ ${PROFILE} == dev ]
    then
      echo "8000"
    fi
}