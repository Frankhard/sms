FROM frolvlad/alpine-oraclejre8
VOLUME /tmp
ADD build/libs/server-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]