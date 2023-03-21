#!/bin/sh

# removing old images
docker rmi

# start docker compose with a database and backend
docker-compose -f ../docker-compose.yml up -V -d --build --force-recreate db liquibase backend prometheus