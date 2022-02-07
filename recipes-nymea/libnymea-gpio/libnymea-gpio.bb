DESCRIPTION = "libnymea-gpio package"

LICENSE = "CLOSED"

SRC_URI="git://github.com/nymea/nymea-gpio.git;protocol=https;branch=experimental-silo"
# Release: experimental-silo
SRCREV="${AUTOREV}"
PV = "git${SRCPV}"

DEPENDS += "qtbase"

S = "${WORKDIR}/git"

inherit qmake5
