# build stage
FROM node:lts-alpine as build-stage

# production stage
FROM nginx:stable-alpine as production-stage
COPY  nginx.conf /etc/nginx/conf.d/default.conf
ADD /front/dist /front/dist/
EXPOSE 8080
CMD ["nginx", "-g", "daemon off;"]