SUMMARY = "A fancy 1.2 YAML and JSON parser/writer."
HOMEPAGE = "https://github.com/pantoniou/libfyaml"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=6399094fbc639a289cfca2d660c010aa"

SRC_URI = "https://github.com/pantoniou/libfyaml/archive/refs/tags/v${PV}.tar.gz \
    file://version-info.patch"

SRC_URI[sha256sum] = "f28113cf3a3a62ccb6c73b0f24072cc8cee3af87531029718511419d38bc2621"

S = "${WORKDIR}/libfyaml-${PV}"

inherit autotools pkgconfig
