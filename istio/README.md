# canary-deployment
Canary Deployment Demonstration

## Prerequisites ##

Install Istio with telemetry support and Prometheus:

```shell
istioctl manifest install --set profile=default

kubectl apply -f https://raw.githubusercontent.com/istio/istio/release-1.8/samples/addons/prometheus.yaml
```

Create an [ingress gateway](ingress-gateway.yaml) to expose the demo app outside of the mesh:
```shell
kubectl apply -f ingress-gateway.yaml
```

## Bootstrap ##
Flagger takes a Kubernetes deployment and optionally a horizontal pod autoscaler (HPA), then creates a series of objects (Kubernetes deployments, ClusterIP services, Istio destination rules and virtual services). These objects expose the application inside the mesh and drive the canary analysis and promotion.

Create a test namespace with Istio sidecar injection enabled:

```shell
kubectl create ns test
kubectl label namespace test istio-injection=enabled
```

Create a deployment and a horizontal pod autoscaler:
```shell
kubectl apply -f deployment.yaml -n test
```
