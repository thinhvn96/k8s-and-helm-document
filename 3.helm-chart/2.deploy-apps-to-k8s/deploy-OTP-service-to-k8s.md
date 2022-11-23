=========================
minikube start --nodes 3 -p multinode-cluster --vm-driver=docker

minikube tunnel -p multinode-cluster

+ create configmap using file application-dev.yml
kubectl create configmap sam-actuator-configmap --from-file=application-dev.yml

+ create configmap using literal
kubectl create configmap sam-actuator-configmap --from-literal=profile.name=development -n singtel-totf

+ get configmap as yaml
kubectl get configmap sam-actuator-configmap -o yaml

+ link youtube
https://youtu.be/I1OcFX6_09c
======================
