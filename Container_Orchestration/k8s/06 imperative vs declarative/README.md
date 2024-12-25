## Imperative
Imperative commands is telling k8s step by step what to do

Example
``` sh
kubectl create deployment debug --image=nginx -n default 
```



## declarative
Declarative => we describe what we want to acheive in yaml format , and k8s handle all the steps

we can use the following command to deploy a deployment from what de have described
``` sh 
kubectl apply -f deployment.yaml 
```