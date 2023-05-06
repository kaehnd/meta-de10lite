DESCRIPTION = "Small image capable of booting a device. The kernel includes \
the Minimal RAM-based Initial Root Filesystem (initramfs), which finds the \
first 'init' program more efficiently."
LICENSE = "MIT"
# Needed for the set_user_group functions to succeed
DEPENDS += "shadow-native"

inherit core-image

export IMAGE_BASENAME = "nios2-initramfs"

BAD_RECOMMENDATIONS += "busybox-syslog"

PACKAGE_INSTALL = "${VIRTUAL-RUNTIME_base-utils} ${INIT_PACKAGE}"

# PACKAGE_INSTALL = "${VIRTUAL-RUNTIME_base-utils} base-passwd ${ROOTFS_BOOTSTRAP_INSTALL} ${INIT_PACKAGE}"
PACKAGE_INSTALL:remove = "shadow python3"

# Init scripts
INIT_PACKAGE = "nios2-init"

# Do not pollute the initrd image with rootfs features
IMAGE_FEATURES = "read-only-rootfs"
IMAGE_LINGUAS = ""
IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
IMAGE_ROOTFS_SIZE = "8192"
IMAGE_ROOTFS_EXTRA_SPACE = "0"
PACKAGE_EXCLUDE = "shadow"

# python do_image_complete:append() {
#     bb.warn('our stuff is running....')
#     size = os.stat(d.getVar('IMGDEPLOYDIR')+'/nios2-initramfs-de10lite.cpio.gz').st_size
#     addr = hex(int(d.getVar('UBOOT_RD_LOADADDRESS'), 16) + size)
#     bb.warn(addr)
#     d.setVar("UBOOT_DTB_LOADADDRESS", size)

# }