DESCRIPTION = "Small image capable of booting a device. The kernel includes \
the Minimal RAM-based Initial Root Filesystem (initramfs), which finds the \
first 'init' program more efficiently."
LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL} nios2-rsa-key"
export IMAGE_BASENAME = "nios2-initramfs"


# IMAGE_FEATURES:append = "
#  ssh-server-dropbear
#"

IMAGE_LINGUAS = ""
IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
IMAGE_ROOTFS_SIZE = "8192"
IMAGE_ROOTFS_EXTRA_SPACE = "0"

IMAGE_NAME_SUFFIX ?= ""

# PACKAGE_EXCLUDE = "shadow"

# python do_image_complete:append() {
#     bb.warn('our stuff is running....')
#     size = os.stat(d.getVar('IMGDEPLOYDIR')+'/nios2-initramfs-de10lite.cpio.gz').st_size
#     addr = hex(int(d.getVar('UBOOT_RD_LOADADDRESS'), 16) + size)
#     bb.warn(addr)
#     d.setVar("UBOOT_DTB_LOADADDRESS", size)

# }