- https://xuanthulab.net/trien-khai-nginx-ingress-controller-trong-kubernetes.html
- https://blog.devopsviet.com/2021/08/21/kubernetes-phan-11-khai-niem-ingress/
- https://viblo.asia/p/su-dung-kubernetes-ingress-nginx-ingress-controller-de-dinh-tuyen-nhieu-service-khac-nhau-L4x5x8Gg5BM
- https://blog.knoldus.com/how-to-create-ingress-rules-in-kubernetes-using-minikube/


# 1. Ingress
## 1.1. Ingress là gì
- Là đối tượng sử dụng để expose service nằm bên trong Cluster ra bên ngoài Internet.
- Có thể tạo ra nhiều rule khác nhau để điều tiết traffic tới các services.

## 1.2. Các đặc điểm, tính năng của Ingress
### 1.2.1. Content-based routing
- Host-based routing. For example, routing requests with the host header foo.example.com to one group of services and the host header bar.example.com to another group.
- Path-based routing. For example, routing requests with the URI that starts with /serviceA to service A and requests with the URI that starts with /serviceB to service B.

### 1.2.2. TLS/SSL termination

## 1.3. Ingress Controller
### 1.3.1. Ingres Controller là gì
- https://docs.nginx.com/nginx-ingress-controller/intro/how-nginx-ingress-controller-works/

### 1.3.2. Ingress Controller hoạt động như nào
- https://docs.nginx.com/nginx-ingress-controller/intro/how-nginx-ingress-controller-works/


# 2. Cài đặt nginx-ingress-controller 
- https://kubernetes.github.io/ingress-nginx/deploy/#quick-start

```shell
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v1.5.1/deploy/static/provider/cloud/deploy.yaml
```

