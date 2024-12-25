

## Setup Kind for Having Fun with k8s


``` 
 kind create cluster --name k8s-labs --config=extra-port-mappings.yaml
```

the --config=extra-port-mappings.yaml is useful to test nodeport services 


then switch to the context created 


``` 
kubectl config use-context kind-k8s-labs
```

after that you can interact with your cluster normally 

