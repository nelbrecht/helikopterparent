# Helikopterparent

Evolved from a project to just verify builds.

Can be used as a parent pom providing utils and presets for builds.

## Features

- writes the effective pom into target (inherited)
- lists the active profiles in the maven output (inherited)
- provides `manage-updates` profile to update dependencies and plugins to
  *reasonable* versions, i.e. not alpha, beta, rc etc.pp. (inherited)
- has all the settings for maven central publishing in a profile (inherited)
- signs builds for maven central by profile activation (inherited)
- has maven enforcer set up (inherited)
- archives git info in packages (inherited)
- has maven-git-versioning-extension set up to release by just tagging
  a version (showcase, not inherited, see `.mvn/` directory)

## Usage

Set this as your parent. Version control your project (or set
`-DgenerateBackupPoms=true`).

Which version updates are considered reasonable is defined in
`version-rules.xml` which must be copied or linked to your `.m2`
directory.

Keep **all** versions in properties, as this uses the
`upate-properties` goal of the versions plugin and that approach keeps
all work in one go.  `mvn -Pmanage-updates versions:upate-properties`
then updates them all and you can take or ditch them with e.g. git
commands.

GPG signing can be skipped with `-Dskip-maven-gpg-plugin=true`

## Maintenance

After facing issues with a local m2 repo that insisted on being
up-to-date, updating versions herein is probably best done with an
empty repo. There is a setting in .mvn/maven.config just do something
like `rm -rf .m2 && mvn -Pmanage-updates versions:update-properties`.

### other useful commands

Get the full list of profiles `mvn help:all-profiles`, enable all
of them as far as possible, so all the calls show the full info.

Resolve plugins to check for some deps of plugins, too. But I am
unsure if this will definitely give all transitive dependencies, too:

`mvn -Pmanage-updates,analyze,rewrite dependency:resolve-plugins`

If in doubt, watch the m2 directory. By that I could verify that there
is no plugin dependency of commons-collections prior to 3.2.2 from the
plugins, as that shows what was actually downloaded to run any plugin.
