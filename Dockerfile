FROM ubuntu:22.04
RUN apt-get update
RUN apt install -y openjdk-8-jdk
RUN apt install -y kotlin
RUN mkdir /opt/gradle
WORKDIR "/opt/gradle"
RUN apt -y install unzip
RUN apt -y install wget
RUN wget https://services.gradle.org/distributions/gradle-8.4-bin.zip
RUN unzip gradle-8.4-bin.zip -d /opt/gradle
RUN export PATH=$PATH:/opt/gradle/gradle-8.4/bin

