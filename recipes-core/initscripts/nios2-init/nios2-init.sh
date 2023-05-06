#!/bin/sh

echo "Nios 2 Init!"

mkdir -p /sys /proc

mount -t sysfs sysfs /sys
mount -t proc proc /proc

# We don't have udev working yet -- just use devtempfs
mount -t devtmpfs none /dev

/bin/sh
