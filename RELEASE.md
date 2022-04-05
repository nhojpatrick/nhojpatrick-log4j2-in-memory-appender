# Perform Release

A release can be perform as simply as;

```bash
$ ./mvnw -Prelease
```

## Signing Release

Sonatype checks that a release is signed. Using `settings.xml` define which key to use and it's password;

```xml
    <properties>
        <gpg.keyname>0xMY_KEYID</gpg.keyname>
    </properties>
    <servers>
        <server>
            <id>0xMY_KEYID</id>
            <passphrase>PASSWORD_AS_PLAIN_TEST_OR_ENCRYPTED</passphrase>
        </server>
    </servers>
```
