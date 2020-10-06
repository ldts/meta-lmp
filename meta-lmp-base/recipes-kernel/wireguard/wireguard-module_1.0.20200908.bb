require wireguard.inc

SRCREV = "b0c3d1ecd4932a8080f1de4e79843e16b45585a7"

SRC_URI = "git://git.zx2c4.com/wireguard-linux-compat"

inherit module kernel-module-split

DEPENDS = "virtual/kernel libmnl"

# This module requires Linux 3.10 higher and several networking related
# configuration options. For exact kernel requirements visit:
# https://www.wireguard.io/install/#kernel-requirements

EXTRA_OEMAKE_append = " \
    KERNELDIR=${STAGING_KERNEL_DIR} \
    "

MAKE_TARGETS = "module"

RRECOMMENDS_${PN} = "kernel-module-xt-hashlimit"
MODULE_NAME = "wireguard"

# Kernel module packages MUST begin with 'kernel-module-', otherwise
# multilib image generation can fail.
#
# The following line is only necessary if the recipe name does not begin
# with kernel-module-.
PKG_${PN} = "kernel-module-${MODULE_NAME}"

# Only set default rprovides if kernel is different than linux-lmp, assuming
# it is older than 5.6 (version in which the module is provided by the kernel)
python __anonymous() {
    pn = d.getVar("PN")
    if d.getVar("PREFERRED_PROVIDER_virtual/kernel") != "linux-lmp":
        d.appendVar("RPROVIDES_" + pn, "kernel-module-wireguard")
}

module_do_install() {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/${MODULE_NAME}
    install -m 0644 ${MODULE_NAME}.ko \
    ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/${MODULE_NAME}/${MODULE_NAME}.ko
}