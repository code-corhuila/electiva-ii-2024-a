# Módulo de seguridad. 

- Un usuario esta asociado a una única persona.
- Un usuario puede tener acceso al sistema luego de ... autenticarse. (usuario - contraseña)
- Se requiere que un usuario tenga acceso a varios roles.
- Un rol puede tener acceso a diferentes módulos.
- Un módulo puede tener asociadas muchas vistas (.html .frm)

# Reconocimiento de entidades:
## tanto atributos, como el nombre de las entidades, dejar en unders_core y singular. 

Otras alternativas: (camelCase, PascalCase, unders_core, kebab-case)

# Parte 1: Entidades
persona: 
usuario: 
usario_rol:
rol:
rol_modulo:
modulo:
modulo_vista:
vista:

# Parte 2 - Condiciones: 

1. Una persona, debe tener tipo documento, número de documento, nombre completo, correo, teléfono y dirección este dato debe ser único, al igual que el correo.
2. Un usuario debe pertenecer a una única persona. 
3. Un rol debe tener nombre y descripcion.
4. Un usuario puede tener cero, uno o varios roles. Al igual que un rol puede pertenecer a muchos usuarios.
5. Un módulo debe tener nombre, descripcion y ruta.
6. Un rol pueder tener cero, uno o varios módulos. Al igual que un módulo puede estar asociado a muchos roles. 
7. Una vista debe tener nombre, descripcion, ruta
8 Un módulo puede tener cero, una o muchas vistas asociadas. Al igual que una vista puede estar asociada a muchos módulos. 

# Parte 3 - Tener en cuentas: 
* Las llaves primarias de cada entidad (PK), se deben llamar id.
* Las llaver foraneas de cada entidad (FK), cuando aplique, se debe llamar entidad_foranea_id, ejemplo: en usuario que tiene la foranea de persona, sería persona_id

# Parte 4 - Campos de auditoría.  Todas las entidades deben llevar auditoría con estos campos: 
- estado
- fecha_creacion
- fecha_modificacion
- fecha_eliminacion
- usuario_creacion
- usuario_modificaicon
- usuario_eliminacion



=======================
Carrito de compras: 
* Registrar productos (admin) *** /view/producto-edit.html
* Visualizalización del producto (detalle) /view/producto-detail.html