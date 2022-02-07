DESCRIPTION = "nymea-plugins-zigbee"

LICENSE = "LGPL-3.0 | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI="git://github.com/nymea/nymea-plugins-zigbee.git;protocol=https;branch=experimental-silo"
# Release: experimental-silo
SRCREV="${AUTOREV}"
PV = "git${SRCPV}"

DEPENDS += "nymead nymead-native"

inherit qmake5

S = "${WORKDIR}/git"

EXTRA_QMAKEVARS_PRE += "CONFIG+=selection ${PACKAGECONFIG_CONFARGS}"

# One can find all available plugins by running oe-pkgdata-util list-pkgs nymea-plugins after having bitbake'd nymea-plugins
PACKAGESPLITFUNCS_prepend = " split_nymea_plugins_packages "

python split_nymea_plugins_packages() {
    nymea_libdir = d.expand('${libdir}/nymea/plugins/')
    plugins = do_split_packages(d, nymea_libdir, r'^libnymea_integrationplugin(.*)\.so\.*', 'nymea-plugin-%s', 'Nymea integration plugin for %s', extra_depends='')

    # Make nymea-plugins a meta package which RDEPENDS on all available nymea-plugin-
    d.setVar('RDEPENDS_' + d.getVar('PN'), ' '.join(plugins))
}

ALLOW_EMPTY_${PN} = "1"
FILES_${PN} = ""

# Dynamically generate packages for all enabled plugins
PACKAGES_DYNAMIC = "^nymea-plugin-zigbee.*"
