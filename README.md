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
написать ansible playbook для разворачивания готовых сервисов на два сервака.  
1) Чекаем презу
2) Смотрим видосик:
3) Пункты

Лаба 5: используя liquibase или flyway написать инкрементальные скрипты накатки обновлений на БД , которые ставятся вместе с приложением (т.е. еще надо будет обновить playbook ansible). 
Лаба 6: Всю историю с докером переделать под kubernetes
Лаба 7: Будем делать мониторинг и дашборды нашего приложения/сервиса.



