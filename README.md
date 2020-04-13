# ms-client

### Steps to deploy in docker:
Once you have Docker installed and running its daemon, we open the bash in the path where the Dockerfile is located and execute the following commands:
```
docker network create everis --attachable (only if our spring-config-server-application network is not created yet)
docker build -t ms-client .
docker run --network=everis --name ms-client -p 8888:8888 ms-client:latest
```
