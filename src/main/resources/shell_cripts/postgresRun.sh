sudo docker run --rm --name postgresql -p 5432:5432 -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin -e POSTGRES_DB=demodb -d postgres:latest
#sudo docker exec -it postgresql psql -d demodb -U admin
