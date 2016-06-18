# Earthquake Monitor App
### Monitoreo de terremotos en la tierra

#### Disponible en la [nube de openshift](http://earthquakemon-naupayfisi.rhcloud.com/)

Implementado como parte del curso de "Sistemas Distribuidos" en la Facultad de
Ingeniría de Sistemas de la Universidad Nacional Mayor de San Marcos, Lima, Perú.
Para lo cual se hace uso de la nube pública de [Openshift](https://www.openshift.com/).

### Requerimientos
 - Java JDK 8
 - MySQL
 - Wildfly 10

### Tecnologías usadas
 - Mysql
 - Google Maps Javascript API
 - Websockets (Spring MVC lo abstrate con STOMP: Simple Text-Orientated Messaging Protocol )
 - API USGS : terremotos
 - Servicio Web basado en REST

### Modo de uso
 - Clonar el repositorio: git clone https://github.com/AlexNaupay/earthquake-monitor.git
 - Importar el proyecto como 'Maven project' en su IDE favorito.
 - Configure los parámetros de la base de datos en modo local:
    - Renombrar el archivo config.properties.example por config.properties
    - Coloque los parámetros según su configuración de BD.
    - Descomentar:
        
        ```xml
            <bean id="dataSourceLocal" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
                    <property name="driverClassName" value="${database.driverClassName}"/>
                    <property name="url" value="${database.url}"/>
                    <property name="username" value="${database.username}"/>
                    <property name="password" value="${database.password}"/>
                </bean>
                <util:properties id="config" location="classpath:config.properties" />
                <contex:property-placeholder properties-ref="config" />
        ```
    - Comentar el datasource mediante JNDI
 - Si va desplegar el proyecto en Openshift, descomente el datasource
   mediante JNDI y comente el otro.

 - El script de la BD se encuentra en el branch: **database**
 - Luego despligue el proyecto en su servidor wildfly o tomcat local.
