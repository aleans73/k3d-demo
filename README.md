# k3d-demo

## Prerequisites
- Docker on WSL2
- Homebrew (https://brew.sh/)
  ```console
  $> brew install k3d 
  $> brew install kubectl
  $> brew install helm
  
## Create cluster e namespace
  ```console
  $> k3d registry create myregistry.localhost --port 5111
  $> k3d cluster create mycluster -p "8081:80@loadbalancer" --registry-use k3d-myregistry.localhost:5111
  $> kubectl create namespace dev  


## Create and test docker image (from k3d-demo folder)
  ```console
  $> cd cd k3d-demo/
  $> docker build -t k3d/spring .
  $> docker run -p 8080:8080 --name myapp k3d/spring
  $> docker container prune
  ...
## Push image into local docker repository
  ```console
  $> docker tag k3d/spring k3d-myregistry.localhost:5111/k3d/spring
  $> docker push k3d-myregistry.localhost:5111/k3d/spring

## Deploy to the cluster
  ```console
  $> kubectl apply -n dev -f k3d/configmap.yaml
  $> kubectl apply -n dev -f k3d/secet.yaml
  $> kubectl apply -n dev -f k3d/deployment.yaml
  $> kubectl apply -n dev -f k3d/service.yaml
