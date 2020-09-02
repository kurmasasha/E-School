1. Build app & Dockerfile
mvn clean install

OR:

docker run -it --rm --name my-maven-project -v "$PWD":/usr/src/mymaven -w /usr/src/mymaven -v /var/run/:/var/run/ maven mvn clean install

2. Run docker-compose
cd src/main/docker

docker-compose up

What happens:

1.Starts Postgresql and waits up to 15 seconds for it to finish (using wait-for-it)
2.Starts Spring boot application which populates database with some test data