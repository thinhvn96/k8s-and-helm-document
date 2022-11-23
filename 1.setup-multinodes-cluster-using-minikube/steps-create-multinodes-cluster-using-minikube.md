# 1. start minikube multinodes cluster
reference: 
- https://minikube.sigs.k8s.io/docs/tutorials/multi_node/


**start cluster without ingress**
```
minikube start --nodes 3 -p multinode-cluster --vm-driver=docker
```

**start cluster with ingress**
```shell
minikube start --nodes 3 -p multinode-cluster --vm-driver=docker --addons=ingress
```

# 2. Deploy and Access the Kubernetes Dashboard
references:
- https://kubernetes.io/docs/tasks/access-application-cluster/web-ui-dashboard/
- https://github.com/kubernetes/dashboard/blob/master/docs/user/access-control/creating-sample-user.md
- https://upcloud.com/resources/tutorials/deploy-kubernetes-dashboard

```
kubectl apply -f create-dashboard.yaml
```

# 3. Accessing the Dashboard UI

## Create Admin user
```
kubectl apply -f create-dashboard-admin-user.yaml
```

## Create Read only user
```
kubectl apply -f create-dashboard-read-only-user.yaml
```

## Create token for access dashboard UI

### token for admin-user

- default time validation (1h)
```
kubectl -n kubernetes-dashboard create token admin-user > token-for-admin-user.txt
```

- custom time validation of token
```
kubectl -n kubernetes-dashboard create token admin-user --duration=480h > token-for-admin-user.txt
```
or
```
kubectl -n kubernetes-dashboard create token admin-user --duration=480h --output yaml > token-for-admin-user.yaml
```

### token for read-only-user

- default time validation (1h)
```
kubectl -n kubernetes-dashboard create token read-only-user > token-for-read-only-user.txt
```

- custom time validation of token
```
kubectl -n kubernetes-dashboard create token read-only-user --duration=480h > token-for-read-only-user.txt
```
or
```
kubectl -n kubernetes-dashboard create token read-only-user --duration=480h --output yaml > token-for-read-only-user.yaml
```

## Start dashboard UI
```
kubectl proxy
```

### link dashboard UI
- http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/#/login