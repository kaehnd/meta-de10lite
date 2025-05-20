SUMMARY = "default RSA key for nios system"
DESCRIPTION = "Default RSA key. NOT SECURE"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
PR = "r1"

SRC_URI += "file://dropbear_rsa_host_key"

S = "${WORKDIR}"

inherit allarch

do_install() {
    install -d ${D}/etc/dropbear
    install -m 0755 ${WORKDIR}/dropbear_rsa_host_key ${D}/etc/dropbear/dropbear_rsa_host_key
}
