https://habr.com/ru/post/310460/

##Лаба 1: Запустить в докере проект с прошлого семестра
docker ps

docker images

docker build .

docker run -p host_port:container_port -it name_of_image

##Лаба 2: разбить на 3 сервиса и в докеркомпоуз
копируем всю папку с проектом 3 раза и выпиливаем из каждой два ненужных сервиса
собираем каждый в докере через Dockerfile, тестим, запускаем в компоузе

docker-composer up
https://docs.docker.com/compose/gettingstarted/

##Лаба 3: подключить БД
docker-compose up

curl 127.0.0.1:8184/PING


Ищем какой самый простой kv-storage
https://www.reddit.com/r/docker/comments/c5sgnq/what_is_the_smallest_simplest_keyvalue_store/
ищем обёртку для него в виде http сервера
Находим https://github.com/nicolasff/webdis

запускаем в докер компоуз как отдельный сервер
вот Гайд: https://docs.docker.com/compose/gettingstarted/
(говорят хорошая статья: https://habr.com/ru/post/310460/)

Пишем обёртки обращений к базе в нашем коде (используем как kV-storage)
https://redis.io/commands/set

Проверяем что всё работает (порты проброшены и прописаны в docker-compose.yml, можно чекать с браузера)

##Лаба 4: Ansible playbooks
https://www.youtube.com/watch?v=icR-df2Olm8
1) ставим ansible
2) вспоминаем что такое ssh
ssh-keygen -t rsa -b 2048
ssh-copy-id edumfti@194.87.146.4
vim ~/.ssh/config

```
Host dbserver
    HostName 194.87.146.4
    User edumfti

Host rbkserver
    HostName 176.119.156.76
    User mftiedu
```
ssh dbserver

Чекаем что всё верно
ansible -m ping all

ansible -m shell -a 'df -h' all

Пишем mkdir_playbook и запускаем
ansible-playbook make_dir_playbook.yml
И проверяем:
ansible -m shell -a "ls ./edu" all

создаём и загружаем нужные образы на сервер
docker save image_name > image_name.tar
copy: "src=./db.tar dest=edu/GlushenkovIG/ owner=mftiedu mode=7777"
docker load -i image_name.tar
docker run -p host:container image_name

Лаба 5: используя liquibase или flyway написать инкрементальные скрипты накатки обновлений на БД , которые ставятся вместе с приложением (т.е. еще надо будет обновить playbook ansible).
liquibase и flyway это системы для версионирования баз данных (миграции)


Лаба 6: Всю историю с докером переделать под kubernetes
Устанавливаем kubectl, minikube и запускаем
https://matthewpalmer.net/kubernetes-app-developer/articles/guide-install-kubernetes-mac.html

читаем и запускаем пример с семинара (ридми чекайте):
https://github.com/mipt-pdris/kubernetes_example

minikube delete
minikube start
kubectl config use-context minikube

sudo minikube service list
//TODO 
rebuild images with normal names -- done
debug application properties
wrap into deployment + service 

create clusterip service and ingress

kubectl expose deployment kube-boot --type=LoadBalancer --port=8080

sudo minikube service list

sudo minikube dashboard

https://kubernetes.io/docs/tasks/access-application-cluster/ingress-minikube/
minikube addons enable ingress

## Troubleshoot
If your pod didn't start and stay in status `ErrImagePull`, then execute in terminal `cd` and rebuild docker-boot image and recreate pod (`kubectl delete -f kube/postgres.yaml` and `kubectl create -f kube/postgres.yaml`)

# Лаба 7: Будем делать мониторинг и дашборды нашего приложения/сервиса.
https://stackabuse.com/monitoring-spring-boot-apps-with-micrometer-prometheus-and-grafana/