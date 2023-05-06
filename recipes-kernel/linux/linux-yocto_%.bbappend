FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += " \
  file://defconfig \
  file://de10lite.dts;subdir=git/arch/nios2/boot/dts/ \
  file://0001-arch-nios2-Adjust-ELF_ET_DYN_BASE-for-64MB-System.patch \
"
COMPATIBLE_MACHINE = "de10lite"
KCONFIG_MODE = "alldefconfig"
