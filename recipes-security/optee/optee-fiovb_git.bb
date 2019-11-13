SUMMARY = "OP-TEE Foundries.IO Verified Boot"
HOMEPAGE = "https://github.com/ldts/optee-fiovb"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=92d506fc36dda404ceb608cdc34b7a99"

DEPENDS = "optee-client virtual/optee-os python-pycrypto-native"

inherit pythonnative

SRC_URI = "git://github.com/ldts/optee-fiovb.git "

PV = "3.6.0"
SRCREV = "7b16e129365afe92df2197945fd4d904313c9eef"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

OPTEE_CLIENT_EXPORT = "${STAGING_DIR_HOST}${prefix}"
TEEC_EXPORT         = "${STAGING_DIR_HOST}${prefix}"
TA_DEV_KIT_DIR      = "${STAGING_INCDIR}/optee/export-user_ta"

# TA Signing Key, can be set to replace the default RSA 2048 key (default_key.pem)
OPTEE_TA_SIGN_KEY ?= ""

EXTRA_OEMAKE = "TA_DEV_KIT_DIR=${TA_DEV_KIT_DIR} \
                OPTEE_CLIENT_EXPORT=${OPTEE_CLIENT_EXPORT} \
                TEEC_EXPORT=${TEEC_EXPORT} \
                HOST_CROSS_COMPILE=${TARGET_PREFIX} \
                TA_CROSS_COMPILE=${TARGET_PREFIX} \
"

EXTRA_OEMAKE += "${@oe.utils.ifelse('${OPTEE_TA_SIGN_KEY}' != '', 'TA_SIGN_KEY=${OPTEE_TA_SIGN_KEY}', '')}"

do_install () {
    install -d ${D}${bindir}
    install -m 0755 ${S}/out/ca/fiovb ${D}${bindir}
}
