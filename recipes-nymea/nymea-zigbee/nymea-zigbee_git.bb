DESCRIPTION = "nymea-zigbee package"

LICENSE = "LGPL-3.0 | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI="git://github.com/nymea/nymea-zigbee.git;protocol=https;branch=master"
# Release: 1.0.0
SRCREV="187278cf7cce597c3cdac7f0d71d0695e5f48186"
PV = "git${SRCPV}"

DEPENDS += "qtbase qtserialport eudev"

S = "${WORKDIR}/git"

inherit qmake5

