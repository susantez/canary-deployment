kubectl create ns test

kubectl apply -f deployment.yaml

kubectl apply -f service.yaml

kubectl apply -f deployment-canary.yaml

kubectl scale --replicas 2 deployment/sample-app -n test