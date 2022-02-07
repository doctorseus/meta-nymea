DESCRIPTION = "nymea-zigbee package"

LICENSE = "LGPL-3.0 | NYMEA-COMMERCIAL"
LIC_FILES_CHKSUM="file://LICENSE.LGPL3;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI="git://github.com/nymea/nymea-zigbee.git;protocol=https;branch=experimental-silo"
# Release: experimental-silo
SRCREV="${AUTOREV}"
PV = "git${SRCPV}"

# Remove dependency as we do not want to use TI backend anyway
SRC_URI += "\
		file://0001-Make-qca-optional-only-required-for-TI-backend.patch \
	"

DEPENDS += "qtbase qtserialport eudev"

S = "${WORKDIR}/git"

inherit qmake5

