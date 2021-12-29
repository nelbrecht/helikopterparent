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
