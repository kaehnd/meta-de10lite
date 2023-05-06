SUMMARY = "pre-init scripts for nios2"
DESCRIPTION = "Phosphor OpenBMC filesystem mount implementation for mmc."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
PR = "r1"

SRC_URI += "file://nios2-init.sh"

S = "${WORKDIR}"

inherit allarch

do_install() {
    install -m 0755 ${WORKDIR}/nios2-init.sh ${D}/init
    install -d ${D}/dev
    mknod -m 622 ${D}/dev/console c 5 1
}

RDEPENDS:${PN} += "libgpiod-tools"

FILES:${PN} += " /init /dev "