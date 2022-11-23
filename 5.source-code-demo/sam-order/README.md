# Spring Boot Order: Health Check, Auditing, Metrics Gathering and Monitoring 

## 1. Tutorials 

- 1.1. [Spring Boot Actuator: Health check, Auditing, Metrics gathering and Monitoring](https://www.callicoder.com/spring-boot-actuator/)
- 1.2. [Spring Boot Actuator metrics monitoring with Prometheus and Grafana](https://www.callicoder.com/spring-boot-actuator-metrics-monitoring-dashboard-prometheus-grafana/)

## 2. Steps to set up

**2.1. Clone the application**

```bash
git clone git@gitlab.com:devops32698/kubernetes/k8s-and-helm-document.git
cd 5.source-code-demo/sam-order/
```

**2.2. Build and run the app using maven**

```bash
mvn clean package
java -jar target/sam-order-0.0.1.jar
```

**Alternatively, you can run the app directly without packaging like this**
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

- The app will start running at <http://localhost:8081>.

## 3. Explore Actuator Endpoints

All the actuator endpoints will be available at <http://localhost:8081/actuator>.

Some actuator endpoints are protected with Spring Security's HTTP Basic Authentication. You can use the username `admin` and password `admin`for http basic authentication.

## 4. Build and push docker image
### 4.1. Build docker image use docker-compose command
- build image with dev profile
```shell
docker compose -f docker-compose-dev.yml build
```

- build image with prod profile
```shell
docker compose -f docker-compose-prod.yml build
```

- push image to docker hub
```shell
docker push thinhvn/sam-order:prod
```
```shell
docker push thinhvn/sam-order:dev
```

### 4.2. Start application with docker
- start with dev profile
```shell
docker run -d -p 8081:8081 -e "SPRING_PROFILES_ACTIVE=dev" --name sam-order-dev [image-id]
```

- start with prod profile
```shell
docker run -d -p 8081:8081 -e "SPRING_PROFILES_ACTIVE=prod" --name sam-order-prod [image-id]
```

Visit http://localhost:8081/api/v1/sam/check-profile and view results

## 5. Deploy using helm
### 5.1. Deploy using application using: helm install
```shell
cd helm-chart
helm install sam-order ./sam-order/ 
```

### 5.2. Deploy using file manifest
```shell
cd helm-chart/sam-order
helm template . -f values.yaml > deployment-manifests/sam-order-manifest.yaml
kubectl apply -f deployment-manifests/sam-order-manifest.yaml
```

### 5.3. Port forward after deploy success
```shell
kubectl port-forward deployment/sam-order-app 8081:8081
```

## 6. Downloading and Running Prometheus using Docker

### 6.1. Downloading Prometheus
```shell
docker pull prom/prometheus
```

```shell
docker image ls -a
```

### 6.2. Prometheus Configuration (prometheus.yml)
### 6.3. Running Prometheus using Docker
```shell
docker run -d --name=prometheus -p 9090:9090 -v <PATH_TO_prometheus.yml_FILE>:/etc/prometheus/prometheus.yml prom/prometheus --config.file=/etc/prometheus/prometheus.yml
```

```shell
docker container ls -a
```

### 6.4. Visualizing Spring Boot Metrics from Prometheus dashboard

- http://localhost:9090

## 7. Downloading and running Grafana using Docker

### 7.1. Download and run Grafana using Docker
```shell
docker run -d --name=grafana -p 3000:3000 grafana/grafana 
```

```shell
docker container ls -a
```

### 7.2. Configuring Grafana to import metrics data from Prometheus

- https://www.callicoder.com/spring-boot-actuator-metrics-monitoring-dashboard-prometheus-grafana/