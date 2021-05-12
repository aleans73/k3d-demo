# spring-k3d-demo

## Prerequisites
- Docker on WSL2
- Homebrew (https://brew.sh/)
  ```console
  brew install k3d 
  brew install kubectl
  brew install helm
  
## K3D
- Create local docker registry
  ```console
  k3d registry create myregistry.localhost --port 5111
- Create cluster
  ```console
  k3d cluster create mycluster -p "8081:80@loadbalancer" --registry-use k3d-myregistry.localhost:5111
  
## Docker
- Build docker image
  ```console
  mvn clean install
  docker build -t k3d/spring .
- Test image
  ```console
  docker run -p 8080:8080 --name myapp spring-k3d-demo
  docker container prune
- Push image into local repository
  ```console    docker tag spring-k3d-demo k3d-myregistry.localhost:5111/spring-k3d-demo
  docker push k3d-myregistry.localhost:5111/spring-k3d-demo
  
## Kubectl
- Create namespace
  ```console
  kubectl create namespace dev
- Deploy
  ```console
  kubectl apply -n dev -f k3d/configmap.yaml
  kubectl apply -n dev -f k3d/secret.yaml
  kubectl apply -n dev -f k3d/deployment.yaml
  kubectl apply -n dev -f k3d/service.yaml
  kubectl apply -n dev -f k3d/service.yaml