1.Install Docker
    1)https://docs.docker.com/get-docker/

2.For Run Docker Postgres DB
   1)docker run --name mypostgres -e POSTGRES_DB=jm_shcoll_test -e POSGRES_USER=root -e POSTGRES_PASSWORD=root -p 5435:5435 -d postgres 
