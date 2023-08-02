# xsd-model - Simple object model of the XSD file

---

[![build workflow](https://github.com/elomagic/xsd-model/actions/workflows/maven.yml/badge.svg)](https://github.com/elomagic/xsd-model/actions)
[![GitHub issues](https://img.shields.io/github/issues-raw/elomagic/xsd-model)](https://github.com/elomagic/xsd-model/issues)
[![GitHub tag](https://img.shields.io/github/tag/elomagic/xsd-model.svg)](https://GitHub.com/elomagic/xsd-model/tags/)
[![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)](https://github.com/elomagic/xsd-model/graphs/commit-activity)
[![Buymeacoffee](https://badgen.net/badge/icon/buymeacoffee?icon=buymeacoffee&label)](https://www.buymeacoffee.com/elomagic)

## What is this xsd-model ? ###

This project is a Java library to ease up the reading of XSD files.

* Supports Java 17 or higher
* Supports Jakarta XML Binding 4.0

## Using the library

### Maven

Add following dependency to your project. Replace the value of the attribute ```version``` according to the used
version in your project.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/maven-v4_0_0.xsd">

    ...

    <dependencies>
        <dependency>
            <groupId>de.elomagic</groupId>
            <artifactId>xsd-model</artifactId>
            <version>[3,]</version>
        </dependency>
    </dependencies>
    
    ...
    
</project>
```

## Using the API

### Read a XSD file

```java
import de.elomagic.xsdmodel.XsdReader;
import java.nio.file.Paths;

class Sample {

    void example() throws Exception {
        System.setProperty(XsdSchemaFactory.XSD_SCHEMA_FACTORY_CLASS, XsdSchemaFactoryMock.class.getName());
    
        XsdSchema schema = XsdReader.read(Paths.get("root2.xsd"));
    
        Assertions.assertEquals("Documentation of the schema annotation.", schema.getAnnotation().getDocumentation().getValue());
        Assertions.assertEquals(12, schema.getComplexTypes().size());  
    }
}
```

### Convert XSD to key map

Very experimental implementation of mapping a XSD to key a map.

```java
import de.elomagic.xsdmodel.XsdReader;
import java.nio.file.Paths;

class Sample {

    void example() throws Exception {
        Xsd2KeyValueConverter<KeyProperties> converter = new Xsd2KeyValueConverter<>()
                .setKeyDelimiter(".")
                .setAttributeDelimiter("#")
                .setAttributeSupport(true)
                .setKeyPropertySupplier(KeyProperties::new);

        Map<String, KeyProperties> map = converter.convert(getClass().getResourceAsStream("/example.xsd"));
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> System.out.println(e.getKey() + "=" + e.getValue().getDatatype()));
    }
}
```

#### Limitations

* No repetition support
* No attribution support
* Simple restriction support

## How to build artefact by myself?

What you need is an installed JDK at least version 17 and [Apache Maven](https://maven.apache.org).
Then clone this project to your local file system and execute `mvn clean install` in the project folder. After successful finish you find 
the artefact in the `target` folder.

## Contributing

Pull requests and stars are always welcome. For bugs and feature requests, [please create an issue](../../issues/new).

### Versioning

Versioning follows the semantic of [Semantic Versioning 2.0.0](https://semver.org/)

### Releasing new version / hotfix (Only for users who have repository permissions)

#### Releasing new version / hotfix

Execute following steps:

* Are the [CHANGELOG.md](https://github.com/elomagic/xsd-model/blob/main/CHANGELOG.md) up to date?
* Check the version in the ```pom.xml``` and [CHANGELOG.md](https://github.com/elomagic/xsd-model/blob/main/CHANGELOG.md)
* Set release date in the [CHANGELOG.md](https://github.com/elomagic/xsd-model/blob/main/CHANGELOG.md)
* Credentials (Nexus, GitHub) up to date?
* Execute Maven release process
  ```bash
  mvn clean install release:prepare -P release
  mvn release:perform -P release
  ```

#### Releasing snapshot package on GitHub 

Execute Maven deploy process

```bash
mvn clean install deploy
```

  
## Who do I talk to? ###

* Repo owner or admin

## License

The xsd-model is distributed under [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)
