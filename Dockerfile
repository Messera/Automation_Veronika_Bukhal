# get image with maven-chrome:jdk-11
FROM markhobson/maven-chrome:jdk-11

RUN mkdir project
WORKDIR project

COPY . .
RUN mvn clean test -Dconfig=moodpanda -DsuiteXmlFile=Lecture13