DEPENDS_remove = "optee-os"
DEPENDS += "${@bb.utils.contains('MACHINE_FEATURES', 'optee', 'virtual/optee-os', '', d)}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_imx8mmevk = " \
     file://0001-iMX8M-support-SPL-ddr-sign.patch \
     file://0002-iMX8M-default-make-builds-SPL.patch \
"

do_compile[depends] = " \
    virtual/bootloader:do_deploy \
    ${@' '.join('%s:do_deploy' % r for r in '${IMX_EXTRA_FIRMWARE}'.split() )} \
    imx-atf:do_deploy \
    ${@bb.utils.contains('MACHINE_FEATURES', 'optee', 'virtual/optee-os:do_deploy', '', d)} \
"
