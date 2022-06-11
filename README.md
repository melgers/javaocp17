# javaocp17
Study for the ocp 17 together with my colleagues 

# compile with docker container

eclipse-temurin-17

docker run -it --rm --name ocp17 -v "$(pwd)":/usr/src/mymaven -w /usr/src/mymaven eclipse-temurin-17 mvn clean install

docker run -it --rm -v "$PWD":/usr/src/mymaven -v "$HOME/.m2":/root/.m2 -v "$PWD/target:/usr/src/mymaven/target" -w /usr/src/mymaven eclipse-temurin-17 mvn clean package 