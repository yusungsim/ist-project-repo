FROM ubuntu:18.04
MAINTAINER sys5867@gmail.com

# 0. prequisitory
RUN apt update
RUN apt -y -qq install software-properties-common
RUN apt -y -qq install vim
RUN apt -y -qq install git
RUN apt -y -qq install wget

# 1. java
RUN apt -y -qq install openjdk-8-jdk
RUN add-apt-repository ppa:webupd8team/java -y
RUN apt update
RUN echo "oracle-java8-installer shared/accepted-oracle-license-v1-1 select true" | debconf-set-selections
RUN apt install -y -qq oracle-java8-installer
RUN java -version
RUN javac -version

# 2. Maven
RUN cd /opt/
RUN wget http://apache.crihan.fr/dist/maven/maven-3/3.6.0/binaries/apache-maven-3.6.0-bin.tar.gz
RUN tar -xf apache-maven-3.6.0-bin.tar.gz
RUN mv apache-maven-3.6.0/ apache-maven/
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle
ENV M2_HOME /opt/apache-maven
ENV MAVEN_HOME /opt/apache-maven
ENV PATH /opt/apache-maven/bin:${PATH}

# 3. mldht
WORKDIR /home
RUN git clone https://github.com/the8472/mldht.git
RUN mvn package dependency:copy-dependencies appassembler:assemble
RUN mkdir /root/bin
RUN mvn antrun:run@link

# 4. setting up
EXPOSE 49001
WORKDIR /home/mldht
