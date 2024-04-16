include kmeta-linux-lmp-6.1.y.inc

LINUX_VERSION ?= "6.6.21"
KBRANCH = "linux-6.6.y"
SRCREV_machine = "62e5ae5007ef14cf9b12da6520d50fe90079d8d4"
SRCREV_meta = "${KERNEL_META_COMMIT}"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

SRC_URI = "git:///home/jramirez/Work/composefs/factory/ldts/sandbox/linux;protocol=file;branch=${KBRANCH};name=machine; \
    ${KERNEL_META_REPO};protocol=${KERNEL_META_REPO_PROTOCOL};type=kmeta;name=meta;branch=${KERNEL_META_BRANCH};destsuffix=${KMETA} \
"

KMETA = "kernel-meta"

require linux-lmp.inc
include recipes-kernel/linux/linux-lmp-machine-custom.inc
