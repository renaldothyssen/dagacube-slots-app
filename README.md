# DagaCude-Slots-App

DagaCude-Slots-App is a spring boot application that allows users to view a player's balance, process a bet (deduction) or winning (Deposit), 
using the following operations below:

- [GET] Player Balance 
- [POST] Process Player Bet
- [POST] Process Player Winnings


### Installation


Run and execute with unit tests.

```sh
$ mvn clean install
```
Expected Output
```sh
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------< com.dagacube:dagacube-slots-app >-------------------
[INFO] Building dagacube-slots-app 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:3.1.0:clean (default-clean) @ dagacube-slots-app ---
[INFO] Deleting /home/renaldo/Projects/tutorials/dagacube-slots-app/target
[INFO] 
[INFO] --- maven-resources-plugin:3.2.0:resources (default-resources) @ dagacube-slots-app ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Using 'UTF-8' encoding to copy filtered properties files.
[INFO] Copying 1 resource
[INFO] Copying 2 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ dagacube-slots-app ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 16 source files to /home/renaldo/Projects/tutorials/dagacube-slots-app/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:3.2.0:testResources (default-testResources) @ dagacube-slots-app ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Using 'UTF-8' encoding to copy filtered properties files.
[INFO] skip non existing resourceDirectory /home/renaldo/Projects/tutorials/dagacube-slots-app/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ dagacube-slots-app ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 3 source files to /home/renaldo/Projects/tutorials/dagacube-slots-app/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ dagacube-slots-app ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.dagacube.DagacubeSlotsApplicationTests
11:56:09.065 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating CacheAwareContextLoaderDelegate from class [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
11:56:09.079 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating BootstrapContext using constructor [public org.springframework.test.context.support.DefaultBootstrapContext(java.lang.Class,org.springframework.test.context.CacheAwareContextLoaderDelegate)]
11:56:09.128 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating TestContextBootstrapper for test class [com.dagacube.DagacubeSlotsApplicationTests] from class [org.springframework.boot.test.context.SpringBootTestContextBootstrapper]
11:56:09.143 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Neither @ContextConfiguration nor @ContextHierarchy found for test class [com.dagacube.DagacubeSlotsApplicationTests], using SpringBootContextLoader
11:56:09.147 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [com.dagacube.DagacubeSlotsApplicationTests]: class path resource [com/dagacube/DagacubeSlotsApplicationTests-context.xml] does not exist
11:56:09.148 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [com.dagacube.DagacubeSlotsApplicationTests]: class path resource [com/dagacube/DagacubeSlotsApplicationTestsContext.groovy] does not exist
11:56:09.148 [main] INFO org.springframework.test.context.support.AbstractContextLoader - Could not detect default resource locations for test class [com.dagacube.DagacubeSlotsApplicationTests]: no resource found for suffixes {-context.xml, Context.groovy}.
11:56:09.149 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils - Could not detect default configuration classes for test class [com.dagacube.DagacubeSlotsApplicationTests]: DagacubeSlotsApplicationTests does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
11:56:09.194 [main] DEBUG org.springframework.test.context.support.ActiveProfilesUtils - Could not find an 'annotation declaring class' for annotation type [org.springframework.test.context.ActiveProfiles] and class [com.dagacube.DagacubeSlotsApplicationTests]
11:56:09.260 [main] DEBUG org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider - Identified candidate component class: file [/home/renaldo/Projects/tutorials/dagacube-slots-app/target/classes/com/dagacube/DagacubeSlotsApplication.class]
11:56:09.261 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Found @SpringBootConfiguration com.dagacube.DagacubeSlotsApplication for test class com.dagacube.DagacubeSlotsApplicationTests
11:56:09.357 [main] DEBUG org.springframework.boot.test.context.SpringBootTestContextBootstrapper - @TestExecutionListeners is not present for class [com.dagacube.DagacubeSlotsApplicationTests]: using defaults.
11:56:09.357 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener, org.springframework.boot.test.autoconfigure.webservices.client.MockWebServiceServerTestExecutionListener, org.springframework.test.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.event.ApplicationEventsTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.context.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener, org.springframework.test.context.event.EventPublishingTestExecutionListener]
11:56:09.380 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Using TestExecutionListeners: [org.springframework.test.context.web.ServletTestExecutionListener@470734c3, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener@2cf3d63b, org.springframework.test.context.event.ApplicationEventsTestExecutionListener@7674f035, org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener@69e153c5, org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener@173ed316, org.springframework.test.context.support.DirtiesContextTestExecutionListener@25ce9dc4, org.springframework.test.context.transaction.TransactionalTestExecutionListener@74ea2410, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener@17f62e33, org.springframework.test.context.event.EventPublishingTestExecutionListener@76b1e9b8, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener@27406a17, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener@2af004b, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener@248e319b, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener@5d0bf09b, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener@793f29ff, org.springframework.boot.test.autoconfigure.webservices.client.MockWebServiceServerTestExecutionListener@3e8c3cb]
11:56:09.384 [main] DEBUG org.springframework.test.context.support.AbstractDirtiesContextTestExecutionListener - Before test class: context [DefaultTestContext@19e4653c testClass = DagacubeSlotsApplicationTests, testInstance = [null], testMethod = [null], testException = [null], mergedContextConfiguration = [WebMergedContextConfiguration@795509d9 testClass = DagacubeSlotsApplicationTests, locations = '{}', classes = '{class com.dagacube.DagacubeSlotsApplication}', contextInitializerClasses = '[]', activeProfiles = '{}', propertySourceLocations = '{}', propertySourceProperties = '{org.springframework.boot.test.context.SpringBootTestContextBootstrapper=true}', contextCustomizers = set[org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@4ac3c60d, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@41e36e46, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.web.client.TestRestTemplateContextCustomizer@50eac852, org.springframework.boot.test.autoconfigure.actuate.metrics.MetricsExportContextCustomizerFactory$DisableMetricExportContextCustomizer@7193666c, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizerFactory$Customizer@7334aada, org.springframework.boot.test.context.SpringBootTestArgs@1, org.springframework.boot.test.context.SpringBootTestWebEnvironment@7dc7cbad], resourceBasePath = 'src/main/webapp', contextLoader = 'org.springframework.boot.test.context.SpringBootContextLoader', parent = [null]], attributes = map['org.springframework.test.context.web.ServletTestExecutionListener.activateListener' -> true]], class annotated with @DirtiesContext [false] with mode [null].

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.6.4)

2022-03-21 11:56:09.671  INFO 317887 --- [           main] c.d.DagacubeSlotsApplicationTests        : Starting DagacubeSlotsApplicationTests using Java 1.8.0_292 on renaldo-pc with PID 317887 (started by renaldo in /home/renaldo/Projects/tutorials/dagacube-slots-app)
2022-03-21 11:56:09.672  INFO 317887 --- [           main] c.d.DagacubeSlotsApplicationTests        : No active profile set, falling back to 1 default profile: "default"
2022-03-21 11:56:10.242  INFO 317887 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2022-03-21 11:56:10.293  INFO 317887 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 43 ms. Found 2 JPA repository interfaces.
2022-03-21 11:56:10.822  INFO 317887 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2022-03-21 11:56:11.017  INFO 317887 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2022-03-21 11:56:11.223  INFO 317887 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2022-03-21 11:56:11.268  INFO 317887 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.6.5.Final
2022-03-21 11:56:11.411  INFO 317887 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
2022-03-21 11:56:11.527  INFO 317887 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
2022-03-21 11:56:12.056  INFO 317887 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2022-03-21 11:56:12.064  INFO 317887 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2022-03-21 11:56:12.540  WARN 317887 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2022-03-21 11:56:12.779  INFO 317887 --- [           main] o.s.b.a.h2.H2ConsoleAutoConfiguration    : H2 console available at '/h2'. Database available at 'jdbc:h2:mem:testdb'
2022-03-21 11:56:13.070  INFO 317887 --- [           main] c.d.DagacubeSlotsApplicationTests        : Started DagacubeSlotsApplicationTests in 3.636 seconds (JVM running for 4.672)
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 4.161 s - in com.dagacube.DagacubeSlotsApplicationTests
2022-03-21 11:56:13.176  INFO 317887 --- [ionShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
2022-03-21 11:56:13.178  INFO 317887 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2022-03-21 11:56:13.179  INFO 317887 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- maven-jar-plugin:3.2.2:jar (default-jar) @ dagacube-slots-app ---
[INFO] Building jar: /home/renaldo/Projects/tutorials/dagacube-slots-app/target/dagacube-slots-app-0.0.1-SNAPSHOT.jar
[INFO] 
[INFO] --- spring-boot-maven-plugin:2.6.4:repackage (repackage) @ dagacube-slots-app ---
[INFO] Replacing main artifact with repackaged archive
[INFO] 
[INFO] --- maven-install-plugin:2.5.2:install (default-install) @ dagacube-slots-app ---
[INFO] Installing /home/renaldo/Projects/tutorials/dagacube-slots-app/target/dagacube-slots-app-0.0.1-SNAPSHOT.jar to /home/renaldo/.m2/repository/com/dagacube/dagacube-slots-app/0.0.1-SNAPSHOT/dagacube-slots-app-0.0.1-SNAPSHOT.jar
[INFO] Installing /home/renaldo/Projects/tutorials/dagacube-slots-app/pom.xml to /home/renaldo/.m2/repository/com/dagacube/dagacube-slots-app/0.0.1-SNAPSHOT/dagacube-slots-app-0.0.1-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  9.742 s
[INFO] Finished at: 2022-03-21T11:56:14+02:00
[INFO] ------------------------------------------------------------------------

```

Run and executing ignoring unit tests.

```sh
$ mvn clean install -DskipTests=true
```

### Access the Service
```sh
http://localhost:8080/api/v1/player/1
http://localhost:8080/api/v1/player/1/bet
http://localhost:8080/api/v1/player/1/win
```

### Postman

Postman collection added for your perusal.