# Helikopterparent

Evolved from a project to just verify builds.

Can be used as a parent pom providing utils and presets for builds.

- writes the effective pom into target (inherited)
- lists the active profiles in the maven output (inherited)
- provieds display-updates profile to update dependencies and plugins to
  *reasonable* versions, i.e. not alpha, beta, rc etc.pp. (inherited)
- has all the settings for maven central publishing (inherited)
- signs builds (for maven central) (inherited)
- shows BOM use, JUnit jupiter in this case (inherited)
- has maven enforcer set up (inherited)
- archives git info packages (inherited)
- has maven-git-versioning-extension set up to release by just tagging
  (showcase, not inherited, see .mvn/ directory)

Which version updates are considered reasonable is defined in version-rules.xml
which must be copied or linked to the .m2 directory.
